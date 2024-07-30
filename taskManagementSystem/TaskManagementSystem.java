class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskId + ", Task Name: " + taskName + ", Status: " + status;
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskManagementSystem {
    private Node head;

    public TaskManagementSystem() {
        this.head = null;
    }

    // Add a task to the linked list
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Search for a task by ID
    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.taskId == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse and display all tasks
    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete a task by ID
    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.task.taskId == taskId) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.task.taskId != taskId) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Task not found.");
        } else {
            current.next = current.next.next;
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();

        // Adding tasks
        tms.addTask(new Task(1, "Design Database", "Pending"));
        tms.addTask(new Task(2, "Develop Backend", "In Progress"));
        tms.addTask(new Task(3, "Create UI", "Completed"));

        // Traverse and display all tasks
        System.out.println("All tasks:");
        tms.traverseTasks();

        // Search for a task
        int searchId = 2;
        Task foundTask = tms.searchTask(searchId);
        if (foundTask != null) {
            System.out.println("Task found: " + foundTask);
        } else {
            System.out.println("Task not found.");
        }

        // Delete a task
        int deleteId = 3;
        tms.deleteTask(deleteId);
        System.out.println("Task with ID " + deleteId + " deleted.");

        // Traverse and display all tasks after deletion
        System.out.println("All tasks after deletion:");
        tms.traverseTasks();
    }
}
