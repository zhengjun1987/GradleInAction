package main.java.com.zhengjun.cn.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryRepository implements ToDoRepository{
    AtomicLong atomicLong = new AtomicLong();
    private ConcurrentHashMap<Long,ToDoItem> hashMap = new ConcurrentHashMap<>();
    @Override
    public List<ToDoItem> findAll() {
        List<ToDoItem> toDoItems = new ArrayList<>(hashMap.values());
        Collections.sort(toDoItems);
        return toDoItems;
    }

    @Override
    public ToDoItem findById(Long id) {
        return hashMap.get(id);
    }

    @Override
    public Long insert(ToDoItem toDoItem) {
        ToDoItem item = hashMap.put(toDoItem.getId(), toDoItem);
        return toDoItem.getId();
    }

    @Override
    public void update(ToDoItem toDoItem) {
        hashMap.put(toDoItem.getId(),toDoItem);
    }

    @Override
    public void delete(ToDoItem toDoItem) {
        hashMap.remove(toDoItem.getId());
    }
}
