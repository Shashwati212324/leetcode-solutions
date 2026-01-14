import java.util.*;

class Solution {

    static class Event {
        long y;
        long x1, x2;
        int type;

        Event(long y, long x1, long x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    static class SegmentTree {
        int[] count;
        long[] length;
        long[] xs;
        int n;

        SegmentTree(long[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            count = new int[4 * n];
            length = new long[4 * n];
        }

        void update(int node, int l, int r, int ql, int qr, int val) {
            if (qr <= l || r <= ql) return;
            if (ql <= l && r <= qr) {
                count[node] += val;
            } else {
                int mid = (l + r) / 2;
                update(node * 2, l, mid, ql, qr, val);
                update(node * 2 + 1, mid, r, ql, qr, val);
            }

            if (count[node] > 0) {
                length[node] = xs[r] - xs[l];
            } else if (l + 1 == r) {
                length[node] = 0;
            } else {
                length[node] = length[node * 2] + length[node * 2 + 1];
            }
        }

        long coveredLength() {
            return length[1];
        }
    }

    public double separateSquares(int[][] squares) {

        List<Event> events = new ArrayList<>();
        Set<Long> xSet = new HashSet<>();

        for (int[] s : squares) {
            long x = s[0], y = s[1], l = s[2];
            events.add(new Event(y, x, x + l, +1));
            events.add(new Event(y + l, x, x + l, -1));
            xSet.add(x);
            xSet.add(x + l);
        }

        long[] xs = xSet.stream().sorted().mapToLong(Long::longValue).toArray();
        Map<Long, Integer> xIndex = new HashMap<>();
        for (int i = 0; i < xs.length; i++) xIndex.put(xs[i], i);

        events.sort(Comparator.comparingLong(e -> e.y));

        SegmentTree st = new SegmentTree(xs);

        long totalArea = 0;
        long prevY = events.get(0).y;

        for (Event e : events) {
            long dy = e.y - prevY;
            totalArea += st.coveredLength() * dy;
            st.update(1, 0, st.n, xIndex.get(e.x1), xIndex.get(e.x2), e.type);
            prevY = e.y;
        }

        double target = totalArea / 2.0;
        double accumulated = 0;

        st = new SegmentTree(xs);
        prevY = events.get(0).y;

        for (Event e : events) {
            long dy = e.y - prevY;
            double area = st.coveredLength() * dy;

            if (accumulated + area >= target) {
                return prevY + (target - accumulated) / st.coveredLength();
            }

            accumulated += area;
            st.update(1, 0, st.n, xIndex.get(e.x1), xIndex.get(e.x2), e.type);
            prevY = e.y;
        }

        return prevY;
    }
}
