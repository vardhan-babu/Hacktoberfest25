class Base{
    String name;
    Base(){
        System.out.println("Base class default constructor called");
    }
    Base(String name){
        System.out.println("Base class parameterize constructor call");
        this.name=name;
    }
    void display(){
        System.out.println("Name is : "+name);
    }
}
class Child1 extends Base{
    int rollno;
    Child1(){
        System.out.println("child1 class default constructor called");
    }
    Child1(String name,int rollno){
        super(name);
        System.out.println("child1 class parameterize constructor called");
        this.rollno=rollno;
    }
    void display(){
        super.display();
        System.out.println("Roll no is : "+rollno);
    }
}
class Child2 extends Child1{
    String course;
    Child2(){
        System.out.println("Child2 class default constructor called : ");
    }
    Child2(String name,int rollno,String course){
        super(name,rollno);
        System.out.println("Child2 class parameterize constructor called : ");
        this.course=course;
    }
    void display(){
        super.display();
        System.out.println("Course is : "+course);
    }
}

class MultilevelInherit{
    public static void main(String s[]){
        Child2 obj = new Child2("deepraj",1001,"MCA");
        obj.display();
    }
}
