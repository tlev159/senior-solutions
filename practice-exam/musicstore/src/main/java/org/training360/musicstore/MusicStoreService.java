package org.training360.musicstore;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class MusicStoreService {

    private AtomicLong id = new AtomicLong();

    private List<Instrument> instruments = Collections.synchronizedList(new ArrayList<>());

    private ModelMapper modelMapper;

    public MusicStoreService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<InstrumentDTO> getInstruments(Optional<String> brand, Optional<Integer> price) {
        Type targetListType = new TypeToken<List<InstrumentDTO>>(){}.getType();
        return modelMapper.map(instruments.stream()
                .filter(i -> brand.isEmpty() || i.getBrand().equalsIgnoreCase(brand.get()))
                .filter(i -> price.isEmpty() || i.getPrice() == price.get())
                .collect(Collectors.toList()), targetListType);
    }

    public InstrumentDTO getInstrumentById(long id) {
        return modelMapper.map(instruments.stream()
                .filter(i -> i.getId() == id)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Instrument with id (" + id + ") not found!")), InstrumentDTO.class);
    }

    public InstrumentDTO createInstrument(CreateInstrumentCommand command) {
        Instrument instrument = new Instrument(id.incrementAndGet(), command.getBrand(), command.getType(), command.getPrice(), LocalDate.now());
        instruments.add(instrument);
        return modelMapper.map(instrument, InstrumentDTO.class);
    }

    public void deleteInstruments() {
        instruments = Collections.synchronizedList(new ArrayList<>());
        id = new AtomicLong();
    }

    public void deleteInstrumentById(long id) {
        Instrument instrument = findInstrument(id);
        instruments.remove(instrument);
    }

    private Instrument findInstrument(long id) {
        Instrument instrument = instruments.stream()
                .filter(i->i.getId() == id)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Instrument not found with id: " + id));
        return instrument;
    }

    public InstrumentDTO updatePrice(long id, UpdatePriceCommand command) {
        Instrument instrument = findInstrument(id);
        if (instrument.getPrice() != command.getPrice()) {
            instruments.get(instruments.indexOf(instrument)).setPrice(command.getPrice());
            instruments.get(instruments.indexOf(instrument)).setPostDate();
        }
        return modelMapper.map(instrument, InstrumentDTO.class);
    }
    
}
