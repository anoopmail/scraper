scraper
=======

An Android libray to scrape a webpage and convert selected dom elements into a java object.


### Usage ###

```java
List<String> items = null ;
Scraper news = new Scraper("http://uk.news.yahoo.com/tech/");
List<String> items = news.pick("li.list-story a");
```
Most of the time, you will be putting these kind of network operations inside a AsyncTask. The wraped code looks like,

```java
private class Download extends AsyncTask<String, String, List<String>>{
		@Override
		protected List<String> doInBackground(String... params) {
			Scraper news = new Scraper("http://uk.news.yahoo.com/tech/");
			List<String> items = null ;
			this.publishProgress("Executing");
			try {
				items = news.pick("li.list-story a");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return items;
		}
		 @Override
		  protected void onPostExecute(List<String> result) {
		  @TODO
		  }
	}
```
