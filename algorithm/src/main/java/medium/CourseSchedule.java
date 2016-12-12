package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 207
 * Link: https://leetcode.com/problems/course-schedule/
 * <p/>
 * Analysis:
 * Topological sort problem.
 * Every time remove the vertices which don't have any predecessor and the arcs from these vertices,
 * until there is no vertices left or all the vertices cannot be removed.
 * The latter situation indicates this graph is not a directed acyclic graph,
 * it has at least one cycle.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        List<Course> courses = new ArrayList<Course>();
        for (int i = 0; i < numCourses; i++) {
            courses.add(new Course(i));
        }
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            if (!courses.get(course).prerequisiteCourses.contains(prerequisite)) {
                courses.get(course).prerequisiteCourses.add(prerequisite);
            }
        }

        while (courses.size() > 0) {
            List<Course> toBeRemovedCourses = getCanBeRemovedCourses(courses);
            if (toBeRemovedCourses.size() == 0) {
                break;
            }
            for (Course removedCourse : toBeRemovedCourses) {
                courses.remove(removedCourse);
                for (Course course : courses) {
                    if (course.prerequisiteCourses.contains(removedCourse.id)) {
                        course.prerequisiteCourses.remove(new Integer(removedCourse.id));
                    }
                }
            }
        }
        return courses.size() == 0;
    }

    private List<Course> getCanBeRemovedCourses(List<Course> courses) {
        if (courses == null || courses.size() == 0) {
            return new ArrayList<Course>();
        }

        List<Course> result = new ArrayList<Course>();
        for (Course course : courses) {
            if (course.prerequisiteCourses.size() == 0) {
                result.add(course);
            }
        }
        return result;
    }

    class Course {
        public List<Integer> prerequisiteCourses;
        public int id;

        Course() {
            prerequisiteCourses = new ArrayList<Integer>();
        }

        Course(int id) {
            this.id = id;
            prerequisiteCourses = new ArrayList<Integer>();
        }
    }
}
