package tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import server.Server;

public class PacketHandler {

	private class TempFile {
		private File file;
		private FileOutputStream fos;

		public TempFile(File file) {
			this.file = file;
			try {
				this.fos = new FileOutputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		public void write(byte[] bytes, int len) {
			try {
				this.fos.write(bytes, 0, len);
			} catch (IOException e) {
				FileHandler.debugPrint("Error writing to file while downloading: " + file.getAbsolutePath());
			}
		}

		@Override
		public void finalize() {
			try {
				this.fos.close();
			} catch (IOException e) {
			}
		}

	}

	//Strings

	//Numbers

	//Lists
	private HashMap<String, TempFile> inProgressFiles= new HashMap<String, TempFile>();

	//Objects
	//private Server server;
	
	public PacketHandler(Server server) {
		//this.server = server;
	}

	/**
	 * Handles incoming file transfer packets by downloading the file.
	 * @param packet The packet with the file transfer data.
	 */
	public void feedDLPack(DataPacket packet) {
		String[] args = packet.getMessage().split(" ");

		if (args[1].equalsIgnoreCase("start")) {
			inProgressFiles.put(args[0] + " from " + packet.getFrom(), new TempFile(new File("")));
		} else if (args[1].equalsIgnoreCase("transfer")) {
			inProgressFiles.get(args[0] + " from " + packet.getFrom()).write(packet.getData(), Integer.parseInt(args[2]));
		} else if (args[1].equalsIgnoreCase("end")) {
			inProgressFiles.get(args[0] + " from " + packet.getFrom()).finalize();
			inProgressFiles.remove(args[0] + " from " + packet.getFrom());
		}
	}

	/**
	 * Handles incoming image packets by constructing the image and then displaying it for the client.
	 * @param packet The packet with a portion of the image data.
	 */
	public void feedImgPacket(DataPacket packet) {
		String[] args = packet.getMessage().split(" ");
		
		if (args[1].equalsIgnoreCase("start")) {
			File file = new File(args[0]);
			inProgressFiles.put(args[0] + " from " + packet.getFrom(), new TempFile(file));
		} else if (args[1].equalsIgnoreCase("transfer")) {
			inProgressFiles.get(args[0] + " from " + packet.getFrom()).write(packet.getData(), Integer.parseInt(args[2]));
		} else if (args[1].equalsIgnoreCase("end")) {
			inProgressFiles.get(args[0] + " from " + packet.getFrom()).finalize();
			inProgressFiles.remove(args[0] + " from " + packet.getFrom());
		}
	}
	
	/**
	 * Handles audio stream packets by playing the incoming audio.
	 * @param packet The packet to be handled.
	 */
	public void feedAudioPacket(DataPacket packet) {
		System.out.println("Received an audio packet.");
	}
	
	/**
	 * Handles audio stream packets by playing the incoming voice audio.
	 * @param packet The packet to be handled.
	 */
	public void feedVoicePacket(DataPacket packet) {
		System.out.println("Received a voice packet.");
	}

}