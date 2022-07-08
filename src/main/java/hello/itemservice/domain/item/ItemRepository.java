package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>(); //static
    private static long sequence = 0L; //static

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findByID(Long id) {
        return store.get(id);
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values()); // Array로 감싸서 반환. store의 값이 변함 없게 감싸서 반환
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = findByID(itemId);

        // 정석은 Item을 하는 것이 아닌 ItemDto 등으로 명을 지어서 업데이트 3개만 해주는게 맞음
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore(){
        store.clear();
    }
}
