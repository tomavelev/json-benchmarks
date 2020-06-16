package benchmark;

import java.time.LocalDate;

public class Dummy {
	private int id;

	private String name;

	public Dummy() {

	}

	public Dummy(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	// problematic field type 1 for minidev json
//		private byte[] data = new byte[1];
//		public byte[] getData() {
//			return data;
//		}
//
//		public void setData(byte[] data) {
//			this.data = data;
//		}


	// problematic field type 2 for minidev json
//	private LocalDate localDate = LocalDate.now();
//	public LocalDate getLocalDate() {
//		return localDate;
//	}
//
//	public void setLocalDate(LocalDate localDate) {
//		this.localDate = localDate;
//	}

}