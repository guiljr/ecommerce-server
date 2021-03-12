package com.ecommerce.service.impl;

import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.Item;
import com.ecommerce.repository.ItemRepository;
import com.ecommerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item findById(Long id) throws ResourceNotFoundException {
        return this.itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item", "id", id));
    }

    @Override
    public List<Item> findAllItems() {

        return this.itemRepository.findAll()
                .stream()
                .map(v -> v)
                .collect(Collectors.toList());
    }

    public Long itemCount() {
        return this.itemRepository.count();
    }

    @Override
    @Transactional
    public Item editItem(long id, Item item) {
        Optional<Item> existingItem = this.itemRepository.findById(id);
        if (existingItem.isPresent()) {
            Item i = existingItem.get();
            i.setDescription(item.getDescription());
            i.setImageUrl(item.getImageUrl());
            i.setItemName(item.getItemName());
            i.setUnitPrice(item.getUnitPrice());
        }
        this.itemRepository.save(existingItem.get());

        return existingItem.get();
    }

    @Override
    public Page<Item> findAllItemsPageable(Pageable pageable) {
        return this.itemRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Item createItem(Item item) {
        return this.itemRepository.save(item);
    }
}
