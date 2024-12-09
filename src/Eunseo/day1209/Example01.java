package Eunseo.day1209;
/*
실습 문제 1: 동물 클래스 상속 및 메서드 오버라이딩
부모 클래스: Animal
속성:
name (동물 이름, 문자열)
메서드:
makeSound(): "동물이 소리를 냅니다."를 출력.
자식 클래스:
Dog: makeSound() 메서드를 오버라이딩하여 "멍멍!"을 출력.
Cat: makeSound() 메서드를 오버라이딩하여 "야옹~"을 출력.
메인 메서드:
Animal 타입의 배열에 Dog와 Cat 객체를 저장한 뒤, 반복문을 사용하여 각 동물의 makeSound()를 호출하세요.
 */
class Animal{
    String name;

    public void makeSound(){
        System.out.println("동물이 소리를 냅니다.");
    }
}

// 오버라이딩은 원래 메소드와 형태가 같아야 하므로
class Dog extends Animal{
    @Override
    public void makeSound(){
        System.out.println("멍멍!");
    }
}

class Cat extends Animal{
    @Override
    public void makeSound(){
        System.out.println("야옹~");
    }
}

public class Example01 {
    public static void main(String[] args) {
        // Animal 타입 배열 선언
        Animal[] animals = new Animal[2];

        // 배열에 Dog와 Cat 객체 저장
        animals[0] = new Dog();
        animals[1] = new Cat();

        // for each 반복문을 사용하여 dog와 cat의 makeSound()를 호출
        for(Animal animal : animals){
            animal.makeSound();
        }
    }
}
