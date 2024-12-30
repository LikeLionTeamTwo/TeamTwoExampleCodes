package Eunseo.day1230;

//객체가 상태가 변하면 Observer에게 자동이로 알리는 디자인 패턴
//유투브구독 서비스

import java.util.ArrayList;
import java.util.List;

//1)옵저버 인터페이스
interface Observer{
    void update(String message);
}

//2) Subject 인터페이스
//
interface Subject{
    //관찰자 등록
    void registerObserver(Observer observer);
    //관찰자 제거
    void removeObserver(Observer observer);

    // 관찰자에게 알림
    void notifyObservers();
}

//3) Subject를 구현하는 클래스
class YouTubeChannel implements Subject{
    private String channelName;
    private List<Observer> observers;

    public YouTubeChannel(String channelName){
        this.channelName = channelName;
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            System.out.println();
            observer.update(channelName + ": 새로운 영상이 업로드 되었습니다. ");
        }
    }

    //영상 업로드
    public void uploadVideo(){
        notifyObservers();
    }
}

//4) 구체적인 Observer 클래스
//구독자
class Subscriber implements Observer{
    private String name;
    public Subscriber(String name){
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println(name + "님, 알림 :"+ message);
    }
}


public class ObserverPractice {
    public static void main(String[] args) {
        //유튜브 채널 생성
        YouTubeChannel channel = new YouTubeChannel("부부개발단");

        //구독자
        Subscriber subscriber1 = new Subscriber("장지현");
        Subscriber subscriber2 = new Subscriber("권태윤");
        Subscriber subscriber3 = new Subscriber("김진경");
        Subscriber subscriber4 = new Subscriber("이서영");
        Subscriber subscriber5 = new Subscriber("강경미");

        //구독자 등록
        channel.registerObserver(subscriber1);
        channel.registerObserver(subscriber2);
        channel.registerObserver(subscriber3);
        channel.registerObserver(subscriber4);
        channel.registerObserver(subscriber5);

        //새로운 영상 업로드
        channel.uploadVideo();

        //구독취소
        channel.removeObserver(subscriber5);

        //새로운 영상 업로드
        channel.uploadVideo();





    }
}