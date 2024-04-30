package structural.decorator;

public abstract class Decorator extends Component{

    protected Component component;

    // 데코레이터를 넣으려면 앞에 주스트림이나 보조스트림을 받아야함 강제해야함
    public Decorator(Component component) {
        this.component = component;
    }
}
