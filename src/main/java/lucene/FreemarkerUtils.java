package lucene;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class FreemarkerUtils {
	private static Directory directory = null;
	private static Analyzer analyzer = null;
	private static IndexWriterConfig config = null;
	
	static {
		analyzer = new IKAnalyzer();
		config = new IndexWriterConfig(analyzer );
		try {
			directory = FSDirectory.open(Paths.get("lucene/ftl"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static IndexWriter getIndexWriter() throws Exception {
		IndexWriter indexWriter = new IndexWriter(directory, config);
		return indexWriter;
	}
	
	public static void returnIndexWriter(IndexWriter indexWriter) throws IOException {
		indexWriter.close();
	}
	
}
