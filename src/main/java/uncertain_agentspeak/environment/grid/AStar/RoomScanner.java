//package main.java.uncertain_agentspeak.environment.grid.AStar;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class RoomScanner {
//    private int rows, columns;
//    private Point startA = new Point();
//    private Point startB = new Point();
//    private Point targetPos = new Point();
//
//    private Node targetNode = new Node();
//
//    private ArrayList<Node> goals = new ArrayList<>();
//    private ArrayList<Node> obstacles = new ArrayList<>();
//
////    private String[][] room;
//    private int[][] room;
//
//    public RoomScanner() {
//        try {
//
//            rows = room.length;
//            columns = room.length;
//
//            startA.setRow(Integer.parseInt(line.split(" ")[0]));
//            startA.setCol(Integer.parseInt(line.split(" ")[1]));
//
//            line = bufferedReader.readLine();
//            startB.setRow(Integer.parseInt(line.split(" ")[0]));
//            startB.setCol(Integer.parseInt(line.split(" ")[1]));
//
//            line = bufferedReader.readLine();
//            targetPos.setRow(Integer.parseInt(line.split(" ")[0]));
//            targetPos.setCol(Integer.parseInt(line.split(" ")[1]));
//
//            targetNode.setPosition(targetPos);
//
//            line = bufferedReader.readLine();
//            int numOfMeetingPoints = Integer.parseInt(line);
//
//            for (int i = 0; i < numOfMeetingPoints; i++) {
//                Point point = new Point();
//                line = bufferedReader.readLine();
//                point.setRow(Integer.parseInt(line.split(" ")[0]));
//                point.setCol(Integer.parseInt(line.split(" ")[1]));
//
//                Node node = new Node();
//                node.setPosition(point);
//                goals.add(node);
//            }
//
//            room = new String[rows][columns];
//            for (int i = 0; i < rows; i++) {
//                line = bufferedReader.readLine();
//                room[i] = line.split("(?<=\\G.{1})");
//                for (int j = 0; j < room[i].length; j++) {
//                    if (room[i][j].equals("X")) {
//                        Node node = new Node();
//                        node.setPosition(new Point(i+1, j+1));
//                        obstacles.add(node);
//                    }
//                }
//                //System.out.println(line);
//            }
//            bufferedReader.close();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public int getRows() {
//        return rows;
//    }
//
//    public int getColumns() {
//        return columns;
//    }
//
//    public Point getStartA() {
//        return startA;
//    }
//
//    public Point getStartB() {
//        return startB;
//    }
//
//    public Point getTargetPos() {
//        return targetPos;
//    }
//
//    public Node getTargetNode() {
//        return targetNode;
//    }
//
//    public ArrayList<Node> getGoals() {
//        return goals;
//    }
//
//    public ArrayList<Node> getObstacles() {
//        return obstacles;
//    }
//
//    public String[][] getRoom() {
//        return room;
//    }
//
//
//}