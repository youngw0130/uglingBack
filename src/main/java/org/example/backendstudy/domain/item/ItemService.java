package org.example.backendstudy.domain.item;

import lombok.RequiredArgsConstructor;
import org.example.backendstudy.domain.item.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

}
