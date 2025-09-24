function lengthOfLongestSubstring(s: string): number {
    let arrObj = {};
    let cArr: number[] = [];
    let start: number = 0;
    let max: number = 1;
    let len: number = s.length;
    if (!s.length) return 0;
    for (let i = 0; i < len; i++) {
        if (s[i] in arrObj) {
            start = Math.max(start, arrObj[s[i]] + 1);
        } 
        arrObj[s[i]] = i;
        max = Math.max(max, i - start + 1);
        console.log(start, max);
    }
    return max;
};