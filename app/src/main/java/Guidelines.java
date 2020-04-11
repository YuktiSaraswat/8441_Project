
public class Guidelines
{
    String id1;
    String name2;
    String phone2;
    String address2;
    String feedback2;
    String medical;
    String transport;
    String food;
    public Guidelines()
    {
    }
    public Guidelines(String id1, String name2, String phone2, String address2, String medical, String transport, String food, String feedback2)
    {
        this.id1=id1;
        this.name2=name2;
        this.phone2=phone2;
        this.address2=address2;
        this.medical=medical;
        this.transport=transport;
        this.food=food;
        this.feedback2=feedback2;
    }
    //Create Getter Method for all attributes
    public void setName2(String name2) {
        this.name2 = name2;
    }
    public void setPhone2(String phone1) {
        this.phone2 = phone2;
    }
    public void setId1(String id1) { this.id1 = id1; }
    public void setAddress2(String address2) {
        this.address2 = address2;
    }
    public void setMedical(String medical) {
        this.medical = medical;
    }
    public void setTransport(String transport) {
        this.transport = transport;
    }
    public void setFood(String food) {
        this.food = food;
    }
    public void setFeedback2(String feedback2) {
        this.feedback2 = feedback2;
    }

}


