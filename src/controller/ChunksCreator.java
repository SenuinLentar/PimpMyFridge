package controller;

public class ChunksCreator {
	private String[] chunks = new String[3];

	/**
	 * Constructor of the ChunksCreator class.
	 */
	public ChunksCreator() {
		this.chunks[0] = "Température :";
		this.chunks[1] = "Tension :";
		this.chunks[2] = "Consigne :";
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
