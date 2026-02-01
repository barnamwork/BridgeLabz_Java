package inheritance;

public class PersonR {
    String name;
    int id;

    PersonR(String name, int id){
        this.name=name;
        this.id=id;
    }

    static void main() {
        Chef chef = new Chef("Gorden Ramsey", 1, "Chef");
        Waiter waiter = new Waiter("John", 9, "Waiter");

        chef.performDuties();
        System.out.println();     waiter.performDuties();
   }

}
interface Worker{
    void performDuties();
}

class Chef extends Person implements Worker{
    String role;

    Chef(String name, int id, String role){
        super(name, id);
        this.role=role;
    }

    public void performDuties(){
        System.out.println("Role of the Person : " + role);
        System.out.println("Name: "+ name);

    }
}

class Waiter extends PersonR implements Worker{
    String role;
    Waiter(String name, int id, String role){
        super(name, id);
        this.role = role;
    }
    public void performDuties(){
        System.out.println("Role of the Person : " + role);
        System.out.println("Name: "+ name);
    }
}
