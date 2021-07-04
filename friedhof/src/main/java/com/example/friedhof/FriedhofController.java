package com.example.friedhof;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/friedhof")
public class FriedhofController {

    private FriedhofService friedhofService;

    public FriedhofController(FriedhofService friedhofService) {
        this.friedhofService = friedhofService;
    }

    @GetMapping("/{plotId}")
    public PlotDTO getPlotByPlotId(@PathVariable("plotId") String plotId) {
        return friedhofService.getPlotByPlotId(plotId);
    }

    @DeleteMapping("/{plotId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlotById(@PathVariable("plotId") String plotId) {
        friedhofService.deletePlotById(plotId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlotDTO addPlot(@RequestBody CreatePlotCommand command) {
        return friedhofService.createPlot(command);
    }

    @GetMapping
    public List<PlotDTO> findPlotsByParameters(@RequestParam Optional<String> nameOfLeaseholder, @RequestParam Optional<String> name) {
        return friedhofService.findPlotsWithParams(nameOfLeaseholder, name);
    }

    @GetMapping
    public List<PersonDTO> listPersonsOfPlot(@RequestParam String plotId) {
        return friedhofService.listPersonsOfPlot(plotId);
    }

    @GetMapping("/{year}")
    public List<PlotDTO> listExpiredPlots(@PathVariable("year") int year) {
        return friedhofService.listExpiredPlots(year);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        friedhofService.deleteAll();
    }
}
