class Solution
{
    public:
        int computeArea(int A, int B, int C, int D, int E, int F, int G, int H)
        {
            int w = min(C, G) - max(A, E);
            int h = min(D, H) - max(B, F);
            return (C - A) *(D - B) + (G - E) *(H - F) - (w <= 0 || h <= 0 ? 0 : w *h);
        }
};