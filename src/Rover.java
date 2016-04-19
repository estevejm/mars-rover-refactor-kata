public class Rover {

    private Vector vector;

    public Rover(int x, int y, String direction) {
        this.vector = new Vector(new Point(x,y), Direction.create(direction));
    }

    public void receive(String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); ++i) {
            Command command = parseCommand(commandsSequence, i);
            interpretAndExecuteCommand(command);
        }
    }

    private Command parseCommand(String commandsSequence, int i) {
        return Command.create(commandsSequence.substring(i, i + 1));
    }

    private void interpretAndExecuteCommand(Command command) {
        if (command.equals(Command.create("r"))) {
            this.vector.rotateRight();
        } else if (command.equals(Command.create("l"))) {
            this.vector.rotateLeft();
        } else if (command.equals(Command.create("f"))) {
            this.vector.moveForward();
        } else {
            this.vector.moveBackwards();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        return vector != null ? vector.equals(rover.vector) : rover.vector == null;

    }

    @Override
    public int hashCode() {
        return vector != null ? vector.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Rover{" +
                "vector=" + vector +
                '}';
    }
}
