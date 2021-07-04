package com.example.friedhof;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class FriedhofService {

    private AtomicLong id = new AtomicLong();

    private List<Plot> plots = Collections.synchronizedList(new ArrayList<>(List.of(
            new Plot(id.incrementAndGet(), "A-1-1", "Minta Zsolt",
                    List.of(
                            new Person("Minta Aladár", LocalDate.of(1960,01,01), LocalDate.of(2019,2,15)),
                            new Person("Minta Balázs", LocalDate.of(1970,02,02), LocalDate.of(2020,3,15))),
                    LocalDate.of(2019,3,3), LocalDate.now())
    )));

    private ModelMapper modelmapper;

    public FriedhofService(ModelMapper modelmapper) {
        this.modelmapper = modelmapper;
    }

    public PlotDTO getPlotByPlotId(String plotId) {
        return modelmapper.map(findPlotByPlotId(plotId), PlotDTO.class);
    }

    private Plot findPlotByPlotId(String plotId) {
        return plots.stream()
                .filter(p->p.getPlotId().equalsIgnoreCase(plotId))
                .findFirst()
                .orElseThrow(()->new NoSuchElementException("Plot with plotId not found!"));
    }

    public void deletePlotById(String plotId) {
        Plot result = findPlotByPlotId(plotId);
        plots.remove(result);
    }

    public PlotDTO createPlot(CreatePlotCommand command) {
        Plot plot = new Plot(id.incrementAndGet(), command.getPlotId(), command.getNameOfLeaseholder(), command.getPeople(), command.getDateOfRedemption(), command.getDateOfExpiration());
        plots.add(plot);
        return modelmapper.map(plot, PlotDTO.class);
    }

    public List<PlotDTO> findPlotsWithParams(Optional<String> nameOfLeaseholder, Optional<String> name) {
        Type targetListType = new TypeToken<List<PlotDTO>>(){}.getType();
        return modelmapper.map(plots.stream()
                .filter(p-> nameOfLeaseholder.isEmpty() || p.getNameOfLeaseholder().equalsIgnoreCase(nameOfLeaseholder.get()))
                .filter(p-> name.isEmpty() || p.getPeople().contains(name.get()))
                .collect(Collectors.toList()), targetListType);
    }

    public void deleteAll() {
        plots.clear();
        id = new AtomicLong();
    }

    public List<PersonDTO> listPersonsOfPlot(String plotId) {
        List<Person> result = plots.stream()
                .filter(p-> p.getPlotId().equalsIgnoreCase(plotId))
                .findFirst()
                .map(Plot::getPeople)
                .orElseThrow(()-> new NoSuchElementException("Can not find any person!"));
        Type targetListType = new TypeToken<List<PersonDTO>>(){}.getType();
                return modelmapper.map(result, targetListType);
    }

    public List<PlotDTO> listExpiredPlots(int year) {
        List<Plot> result = plots.stream()
                .filter(p-> p.getDateOfExpiration().isAfter(LocalDate.of(year - 1, 12, 31)))
                .collect(Collectors.toList());
        Type targetListType = new TypeToken<List<PlotDTO>>(){}.getType();
        return modelmapper.map(result, targetListType);
    }
}
