package com.sky.service;

import com.sky.entity.AddressBook;

import java.util.List;

/**
 * @author CWL
 * @version 1.0
 * @Description
 * @packageName com.sky.service
 * @fileName AddressBookService.java
 * @createTime 2024/8/10
 * @copyright 2024 Amarsoft
 */
public interface AddressBookService {


    List<AddressBook> list(AddressBook addressBook);

    void save(AddressBook addressBook);

    AddressBook getById(Long id);

    void update(AddressBook addressBook);

    void setDefault(AddressBook addressBook);

    void deleteById(Long id);
}