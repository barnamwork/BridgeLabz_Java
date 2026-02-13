package linkedlist;

import java.util.Scanner;

/*
Circular Linked List: Round Robin CPU Scheduling - Fully Commented Implementation

PURPOSE:
This program simulates the Round Robin CPU Scheduling Algorithm
using a Circular Singly Linked List.

WHY CIRCULAR LINKED LIST?
- In Round Robin, processes execute in a circular order
- After the last process, CPU returns to the first process
- Circular linked list naturally models this behavior

NODE STRUCTURE:
- ProcessNode:
  pid            → Process ID (unique)
  burstTime      → Total CPU time required
  remainingTime  → Remaining execution time
  priority       → Priority (not used in RR but stored)
  next           → Pointer to next process (circular)

LIST PROPERTIES:
- head points to the first process
- last node's next always points back to head
- No NULL pointers in traversal

ALGORITHM OVERVIEW:
1. Each process gets CPU for a fixed TIME QUANTUM
2. If remainingTime > quantum:
      - Execute for quantum
      - Move to next process
3. If remainingTime <= quantum:
      - Process finishes
      - Remove it from circular list
4. Continue until no process remains

METRICS CALCULATED:
- Waiting Time = Turnaround Time - Burst Time
- Turnaround Time = Completion Time - Arrival Time (arrival = 0)
- Average Waiting Time
- Average Turnaround Time

EDGE CASES HANDLED:
- Empty process list
- Single process
- Removing head / middle / last process
- Process finishing mid-round

Author: AI Assistant | 2026 | Interview / Exam Ready
*/

// ======================= PROCESS NODE =======================
class ProcessNode {

    int pid;                 // Unique process ID
    int burstTime;           // Original CPU burst time
    int remainingTime;       // Remaining execution time
    int priority;            // Priority (stored but not used)
    ProcessNode next;        // Next process in circular list

    /*
    Constructor initializes process data.
    remainingTime starts equal to burstTime.
    */
    ProcessNode(int id, int bt, int pri) {
        pid = id;
        burstTime = bt;
        remainingTime = bt;
        priority = pri;
        next = null;
    }
}

// ======================= ROUND ROBIN SCHEDULER =======================
public class RoundRobin{

    ProcessNode head;    // Head of circular linked list (ready queue)

    /*
    ADD PROCESS AT END (CIRCULAR INSERTION)

    Steps:
    1. Create new process node
    2. If list is empty:
       - head points to new node
       - new node points to itself (circular)
    3. Otherwise:
       - Traverse to last node
       - last.next = newNode
       - newNode.next = head
    */
    public void addProcess(int id, int bt, int pri) {

        ProcessNode newNode = new ProcessNode(id, bt, pri);

        // Case 1: Empty list
        if (head == null) {
            head = newNode;
            newNode.next = newNode;   // Circular link
            return;
        }

        // Case 2: Non-empty list → find last node
        ProcessNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        // Insert new node at end
        temp.next = newNode;
        newNode.next = head;
    }

    /*
    REMOVE PROCESS BY PROCESS ID

    Steps:
    1. Traverse circular list
    2. If only one node exists:
       - head = null
    3. If removing head:
       - Move head to next
       - Fix last node's next
    4. If removing middle/last:
       - prev.next = current.next
    */
    private void removeProcess(int pid) {

        // If list is empty
        if (head == null)
            return;

        ProcessNode curr = head;
        ProcessNode prev = null;

        do {
            // If target process found
            if (curr.pid == pid) {

                // Case 1: Only one process in list
                if (curr == head && curr.next == head) {
                    head = null;
                }

                // Case 2: More than one process
                else {
                    // If deleting head
                    if (curr == head) {
                        head = head.next;
                    }

                    // Link previous node to next node
                    if (prev != null)
                        prev.next = curr.next;

                    // Fix last node if needed
                    ProcessNode last = head;
                    while (last.next != curr) {
                        last = last.next;
                    }
                    last.next = head;
                }
                return;
            }

            prev = curr;
            curr = curr.next;

        } while (curr != head);
    }

    /*
    SIMULATE ROUND ROBIN SCHEDULING

    Steps:
    1. Initialize system time = 0
    2. Pick current process
    3. Execute for:
       - quantum OR remainingTime (whichever is smaller)
    4. Update remainingTime and system time
    5. If process finishes:
       - Calculate turnaround time
       - Calculate waiting time
       - Remove process
    6. Move to next process
    7. Repeat until list becomes empty
    */
    public void simulate(int quantum) {

        // If no processes exist
        if (head == null) {
            System.out.println("No processes to schedule!");
            return;
        }

        int currentTime = 0;       // Tracks CPU time
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int processCount = 0;

        ProcessNode current = head;

        // Continue until all processes are completed
        while (head != null) {

            // Case 1: Process needs more than one quantum
            if (current.remainingTime > quantum) {

                current.remainingTime -= quantum;
                currentTime += quantum;

                // Move to next process
                current = current.next;
            }

            // Case 2: Process will finish in this round
            else {

                currentTime += current.remainingTime;
                current.remainingTime = 0;

                // Turnaround Time = Completion Time
                int turnaroundTime = currentTime;

                // Waiting Time = Turnaround - Burst Time
                int waitingTime = turnaroundTime - current.burstTime;

                totalWaitingTime += waitingTime;
                totalTurnaroundTime += turnaroundTime;
                processCount++;

                int finishedPid = current.pid;

                // Move pointer before deletion
                current = current.next;

                // Remove completed process
                removeProcess(finishedPid);
            }
        }

        // Display final averages
        System.out.println("\n===== ROUND ROBIN RESULTS =====");
        System.out.println("Average Waiting Time = " +
                (double) totalWaitingTime / processCount);
        System.out.println("Average Turnaround Time = " +
                (double) totalTurnaroundTime / processCount);
        System.out.println("================================");
    }

    // ======================= MAIN METHOD =======================
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RoundRobin rr = new RoundRobin();

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        // Input process details
        for (int i = 0; i < n; i++) {
            System.out.print("Process ID: ");
            int id = sc.nextInt();
            System.out.print("Burst Time: ");
            int bt = sc.nextInt();
            System.out.print("Priority: ");
            int pri = sc.nextInt();

            rr.addProcess(id, bt, pri);
        }

        System.out.print("Enter Time Quantum: ");
        int quantum = sc.nextInt();

        // Start Round Robin simulation
        rr.simulate(quantum);

        sc.close();
    }
}

/*
END OF ROUND ROBIN CPU SCHEDULING
This implementation is suitable for:
- Data Structures exams
- Operating Systems viva
- Interview explanations
*/
