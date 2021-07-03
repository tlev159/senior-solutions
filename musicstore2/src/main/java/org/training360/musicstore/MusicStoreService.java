package org.training360.musicstore;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class MusicStoreService {

    private AtomicLong id = new AtomicLong();

    private ModelMapper modelMapper;

    private List<Instrument> instruments = new ArrayList<>();

    public MusicStoreService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public void deleteAll() {
        instruments.clear();
        id = new AtomicLong();
    }

    public InstrumentDTO createInstrument(CreateInstrumentCommand command) {
        Instrument instrument = new Instrument(id.incrementAndGet(), command.getBrand(), command.getType(), command.getPrice(), LocalDate.now());
        instruments.add(instrument);
        return modelMapper.map(instrument, InstrumentDTO.class);
    }

    public List<InstrumentDTO> getInstruments(Optional<String> brand, Optional<Integer> price) {
        Type targetListType = new TypeToken<List<InstrumentDTO>>(){}.getType();
        return modelMapper.map(instruments.stream()
                .filter(i-> brand.isEmpty() || i.getBrand().equalsIgnoreCase(brand.get()))
                .filter(i->price.isEmpty() || i.getPrice() == price.get())
                .collect(Collectors.toList()), targetListType);
    }

    public InstrumentDTO getInstrumentById(long id) {
        Instrument result = findInstrumentById(id);
        return modelMapper.map(result, InstrumentDTO.class);
    }

    private Instrument findInstrumentById(long id) {
        return instruments.stream()
                .filter(i->i.getId() == id)
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("Instrument not found!"));
    }

    public InstrumentDTO updatePriceById(long id, UpdatePriceCommand command) {
        Instrument result = findInstrumentById(id);
        if (result.getPrice() != command.getPrice()) {
            result.setPrice(command.getPrice());
            result.setPostDate();
        }
        return modelMapper.map(result, InstrumentDTO.class);
    }

    public void deleteInstrumentById(long id) {
        Instrument result = findInstrumentById(id);
        instruments.remove(result);
    }
}
