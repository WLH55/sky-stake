package com.sky.service.impl;

import com.sky.context.BaseContext;
import com.sky.entity.AddressBook;
import com.sky.mapper.AddressBookMapper;
import com.sky.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CWL
 * @version 1.0
 * @Description
 * @packageName com.sky.service.impl
 * @fileName AddressBookServiceImpl.java
 * @createTime 2024/8/10
 * @copyright 2024 Amarsoft
 */
@Service
@Slf4j
public class AddressBookServiceImpl implements AddressBookService {

    @Autowired
    private AddressBookMapper addressBookMapper;

    /**
     * 查询
     *
     * @param addressBook
     * @return
     */

    @Override
    public List<AddressBook> list(AddressBook addressBook) {
        return addressBookMapper.list(addressBook);
    }


    /**
     * 新增地址
     *
     * @param addressBook
     */
    @Override
    public void save(AddressBook addressBook) {
        addressBook.setUserId(BaseContext.getCurrentId());
        addressBook.setIsDefault(0);
        addressBookMapper.insert(addressBook);

    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */

    @Override
    public AddressBook getById(Long id) {
        AddressBook addressBook = addressBookMapper.getById(id);
        return addressBook;
    }

    /**
     * 修改地址
     *
     * @param addressBook
     */
    @Override
    public void update(AddressBook addressBook) {

        //只允许修改自己的地址
        addressBook.setUserId(BaseContext.getCurrentId());
        addressBookMapper.update(addressBook);

    }

    /**
     * 设置默认地址
     *
     * @param addressBook
     */

    @Override
    public void setDefault(AddressBook addressBook) {
        //先把当前用户的所有地址设置为非默认地址
        addressBook.setIsDefault(0);
        addressBook.setUserId(BaseContext.getCurrentId());
        addressBookMapper.updateIsDefaultByUserId(addressBook);

        //然后再将当前地址设置为默认地址
        addressBook.setIsDefault(1);
        addressBookMapper.update(addressBook);


    }

    /**
     * 删除地址
     *
     * @param id
     */

    @Override
    public void deleteById(Long id) {
        addressBookMapper.deleteById(id);

    }


}