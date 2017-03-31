package lucene;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class First {
	public static void main(String[] args) throws IOException {
		//luceneWrite();
		luenceSearch();
	}
	
	public static void luceneWrite() throws IOException {
		
		Analyzer analyzer = new StandardAnalyzer();
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		Directory directory = FSDirectory.open(Paths.get("index/"));
		IndexWriter indexWriter = new IndexWriter(directory, config);
		Document document = new Document();
		
		IndexableField field = new StringField("title", "测试标题", Store.YES);
		TextField textField = new TextField("text", "测试内容", Store.YES);
		document.add(field);
		document.add(textField);
		
		indexWriter.addDocument(document);
		
		indexWriter.close();
		
	}
	
	public static void luenceSearch() throws IOException {
		Directory directory = FSDirectory.open(Paths.get("index/"));
		IndexReader r = DirectoryReader.open(directory);
		IndexSearcher indexSearcher = new IndexSearcher(r);
		
		Term t = new Term("text","测");
		Query query = new TermQuery(t);
		TopDocs search = indexSearcher.search(query , 100);
		
		ScoreDoc[] scoreDocs = search.scoreDocs;
		for (ScoreDoc scoreDoc : scoreDocs) {
			int docId = scoreDoc.doc;
			Document doc = indexSearcher.doc(docId);
			System.out.println(doc.get("title"));
			System.out.println(doc.get("text"));
		}
		
	}
	
}
