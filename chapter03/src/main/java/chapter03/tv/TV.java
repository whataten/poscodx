package chapter03.tv;

public class TV {
    private int volume; // 0 ~ 100
    private int channel; // 1 ~ 255
    private boolean power;

    public TV(int volume, int channel, boolean power) {
        this.volume = volume;
        this.channel = channel;
        this.power = power;
    }

    public void status() {
        String power = (this.power) ? "on" : "off";
        System.out.println("TV[power=" + power + ", channel=" + channel + ", volume=" + volume + "]");
    }

    public void power(boolean flag) {
        this.power = flag;
    }

    public void channel(int select) {
        if (select > 255) {
            this.channel = 1;
        } else if (select < 1) {
            this.channel = 255;
        } else {
            this.channel = select;
        }
    }

    public void channel(boolean up) {
        if (up) {
            if (this.channel == 255) {
                this.channel = 1;
            } else {
                this.channel += 1;
            }
        } else {
            if (this.channel == 0) {
                this.channel = 255;
            } else {
                this.channel -= 1;
            }
        }
    }

    public void volume(int select) {
        if (select > 100) {
            this.volume = 0;
        } else if (select < 1) {
            this.volume = 100;
        } else {
            this.volume = select;
        }
    }

    public void volume(boolean up) {
        if (up) {
            if (this.volume == 100) {
                this.volume = 0;
            } else {
                this.volume += 1;
            }
        } else {
            if (this.volume == 0) {
                this.volume = 100;
            } else {
                this.volume -= 1;
            }
        }
    }
}
