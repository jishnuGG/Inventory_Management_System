package inv;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

@Repository
public class InventoryRepository {
    private final JdbcTemplate template;
    private final JdbcClient jdbcClient;
    private List<Inventory> orders = new ArrayList<>();
    public InventoryRepository(JdbcTemplate template, JdbcClient jdbcClient) {
        this.template = template;
        this.jdbcClient = jdbcClient;
    }
    public String findById(int id) {
        int row=jdbcClient.sql("DELETE FROM inventory WHERE id = :id")
                .param("id",id).update();
        if(row>0){

            return "redirect:/home";
        }else{
            return "error";
        }
    }
    public String increment(int id){
       List<Count> co =  jdbcClient.sql("SELECT count FROM inventory WHERE id = :id").param("id",id)
                .query((rs,rowNum)->new Count(
                        rs.getInt("count")
                )).list();
       int count=(co.get(0)).getCount();
        count++;
        int row=jdbcClient.sql("UPDATE inventory SET count = :count WHERE id=:id;")
                .params(Map.of("id",id,"count",count)).update();
        if(row>0){
            return "deleted_success";
        }
        else{
            return "error";
        }
    }
    public String descrement(int id){
        List<Count> co =  jdbcClient.sql("SELECT count FROM inventory WHERE id = :id").param("id",id)
                .query((rs,rowNum)->new Count(
                        rs.getInt("count")
                )).list();
        int count=(co.get(0)).getCount();
        count--;
        int row=jdbcClient.sql("UPDATE inventory SET count = :count WHERE id=:id;")
                .params(Map.of("id",id,"count",count)).update();
        if(row>0){
            return "deleted_success";
        }
        else{
            return "error";
        }
    }
    public List<Inventory> cat1() {
        return jdbcClient.sql("SELECT * FROM Inventory where category_id=1 ;")
                .query((rs, rowNum) -> new Inventory(
                        rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getInt("category_id"),
                        rs.getInt("price"),
                        rs.getString("description"),
                        rs.getInt("count")
                )).list();
    }
    public List<Inventory> cat2() {
        return jdbcClient.sql("SELECT * FROM Inventory where category_id=2 ;")
                .query((rs, rowNum) -> new Inventory(
                        rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getInt("category_id"),
                        rs.getInt("price"),
                        rs.getString("description"),
                        rs.getInt("count")
                )).list();
    }
    public List<Inventory> cat33() {
        return jdbcClient.sql("SELECT * FROM Inventory where category_id=3 ;")
                .query((rs, rowNum) -> new Inventory(
                        rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getInt("category_id"),
                        rs.getInt("price"),
                        rs.getString("description"),
                        rs.getInt("count")
                )).list();
    }
    public List<Inventory> cat44() {
        return jdbcClient.sql("SELECT * FROM Inventory where category_id=4;")
                .query((rs, rowNum) -> new Inventory(
                        rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getInt("category_id"),
                        rs.getInt("price"),
                        rs.getString("description"),
                        rs.getInt("count")
                )).list();
    }
    public List<Inventory> catg55() {
        return jdbcClient.sql("SELECT * FROM Inventory ;")
                .query((rs, rowNum) -> new Inventory(
                        rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getInt("category_id"),
                        rs.getInt("price"),
                        rs.getString("description"),
                        rs.getInt("count")
                )).list();
    }
    public String update(Integer id, String name, Integer categoryId, Integer price, String description, Integer count) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcClient.sql("Update inventory SET id=:id, name=:name, category_id=:category_id ,price=:price,description=:description,count=:count WHERE id=:id")
                .params(Map.of(
                        "id", id,
                        "name",name,
                        "category_id", categoryId,
                        "price",price,
                        "description", description,
                        "count", count
                ))
                .update();
        return "home";

    }
    public String insert(Integer id, String name, Integer categoryId, Integer price, String description, Integer count) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcClient.sql("INSERT INTO inventory(id, name, category_id,price,description,count) VALUES (:id, :name, :category_id, :price,:description,:count)")
                .params(Map.of(
                        "id", id,
                        "name",name,
                        "category_id", categoryId,
                        "price",price,
                        "description", description,
                        "count", count
                ))
                .update();

        return "home";

    }
}
