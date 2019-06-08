/**
 * Tests the Board class.
 */
public class Main {
	private static Board board;

	public static void main(String[] args) {
		test("Constructing new board...",              () -> { board = new Board(8); });
		test("Adding queen in corner...",              () -> { board.add(0); });
		test("Adding queen one knight's move away...", () -> { board.add(2); });
		test("Adding queen in invalid location...",    () -> { board.add(1); });
		test("Undoing illegal move...",                () -> { board.undo(); });

		test("Ensuring two queens in the same left-diagonal causes conflict...", () -> {
			board = new Board(8);
			board.add(0);
			board.add(7);
			board.add(5);
			board.add(3);
		});

		test("Ensuring two queens in the same right-diagonal causes conflict....", () -> {
			board = new Board(8);
			board.add(7);
			board.add(0);
			board.add(2);
			board.add(4);
		});

		test("Ensuring a populated board of size 1 is correctly marked as solved...", () -> {
			board = new Board(1);
			board.add(0);
		});

		test("Ensuring a legal board of size 4 is marked as solved...", () -> {
			board = new Board(4);
			board.add(1);
			board.add(3);
			board.add(0);
			board.add(2);
		});

		test("Ensuring a board of size 0 is marked as solved...", () -> { board = new Board(0); });
	}

	/**
	 * Runs a test.
	 * @param message The message to print before the test.
	 * @param task The lambda function that executes the test.
	 */
	private static void test(String message, Runnable task) {
		System.out.println(message);
		try { task.run(); }
		catch(Exception e) { e.printStackTrace(); }
		System.out.println(board);
	}
}