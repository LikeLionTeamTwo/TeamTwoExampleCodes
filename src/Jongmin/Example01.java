package Jongmin;

public abstract class Shape {        //여러가지 도형이 있기 때문에 
  protected String color;            //상속받을 변수 색깔

  public Shape(String color) {       //무슨 색깔을 넣을까요?
      this.color = color;
    }

  public String getColor() {         //넣은 색깔을 보여주세요
      return color;
    }

  public abstract double getArea();  //도형에 맞는 넓이를 구해봅시다.
}
//원의 클래스
public class Circle extends Shape {  //Circle은 추상클래스 모양으로부터 상속받은 클래스다.

    private double radius;           // 반지름을 변수로 지정한다. int 사용 시 결과값의 소수점이 짤린다.
    public Circle(String color, double radius) {  //색깔과 반지름의 길이를 지정한다.
        super(color);                //추상 클래스로부터 상속받기 때문에 super(color)를 써도 지장 없다.
        this.radius = radius;        //지정한 반지름의 길이를 가져온다.
    }
    @Override                        //추상클래스에 넓이를 정의한 것이 없기 때문에 Override를 사용한다.
    public double getArea() {
        return Math.PI * radius * radius;  //원의 넓이 값을 구한 결과값을 가져온다.
    }
}

//사각형의 클래스
public class Rectangle extends Shape {  //Rectange도 마찬가지로 추상클래스 모양으로부터 상속받은 클래스다.
    private double width;               //가로를 변수로 지정한다.
    private double height;              //세로를 변수로 지정한다.
    public Rectangle(String color, double width, double height) {  //색깔, 가로, 세로의 길이를 지정한다.
        super(color);                   //추상 클래스로부터 상속받기 때문에 super(color)를 써도 지장 없다.
        this.width = width;             //지정한 가로의 길이를 가져온다.
        this.height = height;           //지정한 세로의 길이를 가져온다.
    }

    @Override                      //추상클래스에 넓이를 정의한 것이 없기 때문에 Override를 사용한다.
    public double getArea() {
        return width * height;    //사각형의 넓이인 가로 곱하기 세로 곱한 값을 가져온다.
    }
}

//정삼각형의 클래스
public class RegTriangle extends Shape {  //내용 동문
    private double adjacent;              //정삼각형의 경우는 한변의 길이만을 가지고 넓이를 알 수 있기 때문에 adjacent 변수를 지정한다.

    public RegTriangle(String color, double adjacent) {  //내용 동문.
        super(color);                                    //super 내용 동문
        this.adjacent = adjacent;                        //this 내용 동문
    }

    @Override
    public double getArea() {                            //정삼각형의 넓이를 구해보자.
        return Math.sqrt(3) * Math.pow(adjacent, 2) / (double)4;  //정삼각형의 넓이는 제곱근을 사용해야 하므로 Math 함수에서 sqrt를 가져온다. 
                                                                  //변의 제곱이 필요하기 때문에 pow 함수고 가져왔다
    }


//마름모의 클래스
public class Rhombus extends Shape {                  //상속 내용 동문
    private double width;                             //사각형 내용 동문
    private double height;                            //동문
    private String color;                             //동문

    public Rhombus(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }
    @Override
    public double getArea() {
        return width * height / 2;                    //마름모의 경우는 일반 삼각형 구하는 공식과 동일하다.
    }
}

//정육각형의 클래스
public class Hexagon extends RegTriangle{            //정육각형은 정삼각형 6개를 하나로 모을 수 있는 도형이므로 정삼각형의 클래스를 상속받았다.
    public Hexagon(String color, double adjacent) {  //정삼각형의 클래스를 그대로 가져왔다
        super(color, adjacent);                      //정삼각형에 컬러와 한변의 길이가 있으므로 모두 super메소드를 사용했다.
    }
}

//도형 Lab: 도형의 결과값을 출력한 main Lab
public class ShapeLab {
    public static void main(String[] args) {
        //Shape shape = new Shape(); 추상클래스는 인스턴스화가 불가능
        //나머지는 클래스와 똑같이 사용됨
        //타입으로의 역할은 가능하다.
        Shape shape = new Circle("blue", 7.2);  //색깔과 반지름의 길이를 입력한다.
        System.out.println("color: " + shape.getColor()+ " \t area: " + shape.getArea());

        Shape shape2 = new Rectangle("red", 7.8, 8.9);
        System.out.println("color: " + shape2.getColor() + " \t area: " + shape2.getArea());

        Shape shape3 = new RegTriangle("black", 7.7);
        System.out.println("color: " + shape3.getColor() + " \t area: " + shape3.getArea());

        Shape shape4 = new Rhombus("white", 8.4, 9.5);
        System.out.println("color: " + shape4.getColor() + " \t area: " + shape4.getArea());

        Shape shape5 = new Hexagon("orange", 10);
        System.out.println("color: " + shape5.getColor() + " \t area: " + 6* shape3.getArea());  //정육각형은 정삼각형 6개를 모인 도형이므로 삼각형의 넓이에 6을 곱해도 무관하다.
    }
}
