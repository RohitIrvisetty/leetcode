function longestCommonPrefix(strs: string[]): string {
    let reference: string = strs.sort((a, b) => {
        return Number(a)-Number(b);
    })[0];
    let strs_len: number = strs.length;
    if (strs_len <= 1) return reference;
    console.log(reference);
    for (let i = 0; i < strs_len; i++) {
        loop2:
        for (let j = 0; j < reference.length; j++) {
            if (reference[j] !== strs[i][j]) {
                reference = reference.slice(0, j);
                break loop2;
            }
        }
    }
    return reference;
};