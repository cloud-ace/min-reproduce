package com.example;

import java.util.Arrays;
import org.apache.beam.sdk.*;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.io.gcp.bigquery.BigQueryIO;
import org.apache.beam.sdk.io.gcp.bigquery.BigQueryIO.Write.*;
import com.google.api.services.bigquery.model.TableRow;

public class App {
	public static void main(String[] args) {
		var pipeline = Pipeline.create();
		PCollection<String> pc1 = pipeline.apply(Create.of(Arrays.asList("Hello", "World!")));
		pc1.apply(BigQueryIO.<String>write()
			.to("${Your_Google_Cloud_Project}:${BigQuery_Dataset_Name}.${BigQuery_Table_Name}")
			.withFormatFunction((in) -> { return new TableRow().set("Name", in); })
			.withCreateDisposition(CreateDisposition.CREATE_NEVER)
			.withWriteDisposition(WriteDisposition.WRITE_APPEND)
			.withMethod(BigQueryIO.Write.Method.STORAGE_WRITE_API));
		pipeline.run();
	}
}