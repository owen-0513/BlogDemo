package com.owenblog.service;

import com.owenblog.NotFoundException;
import com.owenblog.entity.Type;
import com.owenblog.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by owen on 2023/10/28.
 */
@Service
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    //    @Transactional
//    @Override
//    public Type saveType(Type type) {
//        return typeRepository.save(type);
//    }
    public Type saveType(Type type) {
        try {
            Type savedType = typeRepository.save(type);
            return savedType;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("保存失敗");
        }
    }

//    @Transactional
//    @Override
//    public Type getType(Long id) {
//
//        return typeRepository.findOne(id);
//    }

    public Type getType(Long id) {
        Type type = typeRepository.findOne(id);
        if (type == null) {
            throw new NotFoundException("不存在的類型");
        }
        return type;
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }


    @Override
    public List<Type> listTypeTop(Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "blogs.size");
        Pageable pageable = new PageRequest(0, size, sort);
        return typeRepository.findTop(pageable);
    }


//    @Transactional
//    @Override
//    public Type updateType(Long id, Type type) {
//        Type t = typeRepository.findOne(id);
//        if (t == null) {
//            throw new NotFoundException("不存在的類型");
//        }
//        BeanUtils.copyProperties(type, t);
//        return typeRepository.save(t);
//    }


    @Override
    public Type updateType(Long id, Type updatedType) {
        Type data = typeRepository.findOne(id);
        if (data == null) {
            throw new NotFoundException("不存在的類型");
        }
        data.setName(updatedType.getName());

        return typeRepository.save(data);
    }


    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRepository.delete(id);
    }
}
