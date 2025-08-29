package main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListWorker {
    private final Conector conector = new Conector();

    public void addTask(String task) {
        String query = "insert into tasks(taskName) values(?)";
        try (PreparedStatement ps = Conector.getConnection().prepareStatement(query)) {
            ps.setString(1, task);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTask(String task, String description) {
        String query = "insert into tasks(taskName, taskDescription) values(?, ?)";
        try (PreparedStatement ps = conector.getConnection().prepareStatement(query)) {
            ps.setString(1, task);
            ps.setString(2, description);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTask(int id) {
        String query = "delete from tasks where idtasks=?";
        try (PreparedStatement ps = conector.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printGroupOfTasks(Status status) {
        String query = "select * from tasks where taskStatus=?";
        if (status != null) {
            String str = statusToString(status);
            try (PreparedStatement ps = conector.getConnection().prepareStatement(query)) {
                ps.setString(1, str);
                ResultSet res = ps.executeQuery();
                while (res.next()) {
                    System.out.println("ID: " + res.getInt("idtasks") +
                            "\n NAME: " + res.getString("taskName") +
                            "\n STATUS: " + res.getString("taskStatus") +
                            "\n Description: " + res.getString("taskDescription"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            query = "select* from tasks";
            try (Statement statement = conector.getConnection().createStatement()) {
                ResultSet res = statement.executeQuery(query);
                while (res.next()) {
                    System.out.println("ID: " + res.getInt("idtasks") +
                            "\n NAME: " + res.getString("taskName") +
                            "\n STATUS: " + res.getString("taskStatus") +
                            "\n Description: " + res.getString("taskDescription"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void changeStatus(int id, Status status) {
        String query = "update tasks set taskStatus = ? where idtasks = ?";

        try (PreparedStatement ps = conector.getConnection().prepareStatement(query)) {
            ps.setString(1, statusToString(status));
            ps.setInt(2, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void changeName(int id, String taskName) {
        String query = "update tasks set taskName=? where idtasks=?";

        try (PreparedStatement ps = conector.getConnection().prepareStatement(query)) {
            ps.setString(1, taskName);
            ps.setInt(2, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void changeDescription(int id, String description) {
        String query = "update tasks set taskDescription=? where idtasks=?";

        try (PreparedStatement ps = conector.getConnection().prepareStatement(query)) {
            ps.setString(1, description);
            ps.setInt(2, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void changeTask(int id, Status status, String taskName) {
        String query = "update tasks set taskStatus = ?, taskName=? where idtasks=?";

        try (PreparedStatement ps = conector.getConnection().prepareStatement(query)) {
            ps.setString(1, statusToString(status));
            ps.setString(2, taskName);
            ps.setInt(3, id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private String statusToString(Status status) {
        String str = null;
        switch (status) {
            case DONE -> str = "done";
            case NOTSTARTED -> str = "not started";
            case STARTED -> str = "started";
        }
        return str;
    }

    public boolean idCheck(int id) {
        String query = "select * from tasks where idtasks = ?";
        try (PreparedStatement ps = conector.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();

            if (res.next()) {
                return true;
            } else return false;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getTaskName(int ID){
        String query = "Select taskName from tasks where idtasks=?";

        try (PreparedStatement ps = conector.getConnection().prepareStatement(query)) {
            ps.setInt(1, ID);
            ResultSet res = ps.executeQuery();
            if(res.next()){
            return res.getString("taskName");
            }else {
                return null;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    return "";

    }


}
