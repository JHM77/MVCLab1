package com.example.MvcLab1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppRepository {

    @Autowired
    private DataSource dataSource;

    public List<Task> getList() {
        List<Task> listAll = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM Task")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Task task = new Task();
                task.setId(rs.getInt(1));
                task.setDescription(rs.getString(2));
                task.setComment(rs.getString(3));
                task.setOwner(rs.getString(4));
                task.setIsCompleted(rs.getBoolean(5));
                listAll.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  listAll;
    }

    public List<Task> getListToDo() {
        List<Task> listToDo = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM Task WHERE IS_COMPLETED = 0")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Task task = new Task();
                task.setId(rs.getInt(1));
                task.setDescription(rs.getString(2));
                task.setComment(rs.getString(3));
                task.setOwner(rs.getString(4));
                task.setIsCompleted(rs.getBoolean(5));
                listToDo.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listToDo;
    }

    public List<Task> getListDone() {
        List<Task> listDone = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM Task WHERE IS_COMPLETED = 1")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Task task = new Task();
                task.setId(rs.getInt(1));
                task.setDescription(rs.getString(2));
                task.setComment(rs.getString(3));
                task.setOwner(rs.getString(4));
                task.setIsCompleted(rs.getBoolean(5));
                listDone.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDone;
    }

    public List<Task> searchRepo(String keyword) {
        ArrayList<Task> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM Task WHERE Description LIKE ? OR Comment LIKE ? OR Owner LIKE ?")) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Task task = new Task();
                task.setId(rs.getInt(1));
                task.setDescription(rs.getString(2));
                task.setComment(rs.getString(3));
                task.setOwner(rs.getString(4));
                task.setIsCompleted(rs.getBoolean(5));
                result.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void addTask (Task newTask) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO Task (Description, Comment, Owner, Is_Completed) VALUES (?,?,?,?)")) {
            ps.setString(1, newTask.getDescription());
            ps.setString(2, newTask.getComment());
            ps.setString(3, newTask.getOwner());
            ps.setBoolean(4, newTask.getIsCompleted());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}