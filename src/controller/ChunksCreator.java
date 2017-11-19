package controller;

public class ChunksCreator {
	private String[] chunks = new String[2];

	/**
	 * Constructor of the ChunksCreator class.
	 */
	public ChunksCreator() {
		this.chunks[0] = "0";
		this.chunks[1] = "1";
	}

	/**
	 * The getter of chunks.
	 * 
	 * @return chunks
	 */
	public String[] getChunks() {
		return chunks;
	}

	/**
	 * The setter of chunks.
	 * 
	 * @param string
	 */
	public void setChunks(String[] string) {
		this.chunks = string;
	}

}
