package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    // subjectUnderTest_actionOrInput_resultState
    fun getActiveAndCompletedStats_noCompletedOneActive_returnsZeroHundred() {
        // GIVEN
        val tasks = listOf(
                Task("title", "description", false)
        )

        // WHEN
        val result = getActiveAndCompletedStats(tasks)

        // THEN
        assertEquals(0F, result.completedTasksPercent)
        assertEquals(100F, result.activeTasksPercent)
    }

    @Test
    // subjectUnderTest_actionOrInput_resultState
    fun getActiveAndCompletedStats_twoCompletedThreeActive_returnsFortySixty() {
        val tasks = listOf(
                Task("title", "description", true),
                Task("title", "description", true),
                Task("title", "description", false),
                Task("title", "description", false),
                Task("title", "description", false)
        )

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(40F, result.completedTasksPercent)
        assertEquals(60F, result.activeTasksPercent)
    }

    @Test
    // subjectUnderTest_actionOrInput_resultState
    fun getActiveAndCompletedStats_noCompletedNoActive_returnsZeroZero() {
        val tasks = emptyList<Task>()

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(0F, result.completedTasksPercent)
        assertEquals(0F, result.activeTasksPercent)
    }

    @Test
    // subjectUnderTest_actionOrInput_resultState
    fun getActiveAndCompletedStats_nullTask_returnsZeroZero() {
        val tasks = null

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(0F, result.completedTasksPercent)
        assertEquals(0F, result.activeTasksPercent)
    }
}