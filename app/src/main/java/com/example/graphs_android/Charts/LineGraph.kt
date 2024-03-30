package com.example.graphs_android.Charts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

@Composable
fun LineGraph(
    xData: List<Float>,
    yData: List<Float>,
    dataLabel: String,
    modifier: Modifier = Modifier
){
    AndroidView(
        modifier = modifier.fillMaxSize(),
        factory = { context ->
            val chart = LineChart(context)  // Initialise the chart
            val entries: List<Entry> = xData.zip(yData) { x, y -> Entry(x, y) }  // Convert the x and y data into entries
            val dataSet = LineDataSet(entries, dataLabel)  // Create a dataset of entries
            chart.data = LineData(dataSet)  // Pass the dataset to the chart

            // Refresh and return the chart
            chart.invalidate()
            chart
        }
    )
}

@Preview(showBackground = true)
@Composable
fun Demo(){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Box(modifier = Modifier.height(400.dp).width(400.dp)) {
            LineGraph(
                xData = listOf(1.0f, 5.0f, 10.0f),
                yData = listOf(10.2f, 9.3f, 5.2f),
                dataLabel = "Temp Graph"
            )
        }
    }
}