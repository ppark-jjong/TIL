package documents;

import java.util.LinkedList;

public class DocumentManager {
	LinkedList<Documents> documents = new LinkedList<>();
	 public void makeDocument(String day, String name, String content) {
	        if (day.isEmpty()) {
	            documents.add(new Documents(name, content));
	        }
	        else {
	            documents.add(new Documents(day, name, content));
	        }
	    }

	    public void deletDocument(String name) {
	        if (name.isEmpty()) {
	            documents.clear();
	        }
	        else {
	            for (Documents document : documents) {
	                if (document.equals(name)) {
	                    documents.remove(document);
	                }
	            }
	        }
	    }

	    public void recontent(String name, String content) {
	        for (Documents document : documents) {
	            if (document.equals(name)) {
	                document.setContent(content);
	            }
	        }
	    }

	    public Documents returnDocument(String name) {
	        for (Documents document : documents) {
	            if (document.equals(name)) {
	                return document;
	            }
	        }

	        return null;
	    }

		public void searchDocument(String name) {
			// TODO Auto-generated method stub
			
		}
}
