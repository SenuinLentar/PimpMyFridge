package controller;

public class ChunksCreator {
	private String[] chunks = new String[2];

	public ChunksCreator() {
		this.chunks[0] = "0";
		this.chunks[1] = "1";
	}

	public String[] getChunks() {
		return chunks;
	}

	public void setChunks(String[] chunks) {
		this.chunks = chunks;
	}

}
