package jdbc_connection;

public class Stock {

		//모델 1:1 대응(MVC패턴)
	    private String CODE;
	    private String CNAME;
	    
	    public Stock(String cODE, String cNAME) {
			super();
			CODE = cODE;
			CNAME = cNAME;
		}	    

	    public Stock() {
			// TODO Auto-generated constructor stub
		}
	    
		public String getCODE() {
			return CODE;
		}



		public void setCODE(String cODE) {
			CODE = cODE;
		}



		public String getCNAME() {
			return CNAME;
		}



		public void setCNAME(String cNAME) {
			CNAME = cNAME;
		}



		@Override
	    public String toString() {
	        return "Student [CODE=" + CODE + ", CNAME=" + CNAME + "]";
	    }

}