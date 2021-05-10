interface ProxyInterface {
    public void proxyMethod(){

    }
}
class RealObject implements ProxyInterface{
    public void proxyMethod(){
        System.out.println("this is a realObject")
    }
}
class ProxyObject implements ProxyInterface{
    public void proxyMethod(){
        //do something befor
        new RealObject().proxyMethod();
        //do somrthing after
    }
}
public class test{
    public static void consumer(ProxyObject po){
        po.proxyMethod();
    }
    public static void main(String[] args){
        consumer(new ProxyObject);
    }
}