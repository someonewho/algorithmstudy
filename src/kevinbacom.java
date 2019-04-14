
import java.util.Scanner;

public class kevinbacom {

	static int INF = 987654321;
	static int MAX = 101;
	static int N, M;

	static int[][] graph = new int[MAX][MAX];

	// �������� �÷��̵� �˰���
	static void floyd() {

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == j)
						continue;
					else if (graph[i][k] > 0 && graph[k][j] > 0) {
						if (graph[i][j] == 0)
							graph[i][j] = graph[i][k] + graph[k][j];// �������� ���� ������ϹǷ�
						else
							graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int node1, node2;
			node1 = sc.nextInt();
			node2 = sc.nextInt();
			graph[node1][node2] = 1;
			graph[node2][node1] = graph[node1][node2];
		}
		floyd();
		int result = INF;
		int person = 0;
		for (int i = 1; i <= N; i++) {

			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += graph[i][j];
			}
			if (result > sum) {
				result = sum;
				person = i; // �ش� ����� ����
			}

		}
		System.out.println(person);

	}

}
