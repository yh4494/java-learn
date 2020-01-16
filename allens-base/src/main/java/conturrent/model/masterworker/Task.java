package conturrent.model.masterworker;

import lombok.Data;

@Data
public class Task {

    private int id;
    private int price;

    public Task(int id, int price) {
        super();
        this.id = id;
        this.price = price;
    }

    public Task(){
    }
}
