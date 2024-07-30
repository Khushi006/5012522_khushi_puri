public class HomeAutomationApp {
    public static void main(String[] args) {
        // Create the receiver
        Light livingRoomLight = new Light();

        // Create concrete commands
        Command lightOnCommand = new LightOnCommand(livingRoomLight);
        Command lightOffCommand = new LightOffCommand(livingRoomLight);

        // Create the invoker
        RemoteControl remote = new RemoteControl();

        // Execute commands using the remote control
        remote.setCommand(lightOnCommand);
        remote.pressButton();

        remote.setCommand(lightOffCommand);
        remote.pressButton();
    }
}

// Step 2: Define Command Interface
interface Command {
    void execute();
}

// Step 3: Implement Concrete Commands
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Step 4: Implement Invoker Class
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command set.");
        }
    }
}

// Step 5: Implement Receiver Class
class Light {
    public void turnOn() {
        System.out.println("The light is on.");
    }

    public void turnOff() {
        System.out.println("The light is off.");
    }
}

