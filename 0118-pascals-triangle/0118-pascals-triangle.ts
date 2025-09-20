function generate(numRows: number): number[][] {
    let output: number[][] = Array(numRows)
    .fill(null)
    .map((_, i) => Array(i + 1));
    for (let i = 0; i < numRows; i++) {
        for (let j = 0; j <= i; j++) {
            if (j == 0 || j == i) {
                //console.log(i, j);
                output[i][j] = 1;
            } else {
                //console.log(i, j, output[i-1][j], output[i-1][j+1], output);
                output[i][j] = output[i-1][j] + output[i-1][j-1];
            }
        }
    }
    return output;
};