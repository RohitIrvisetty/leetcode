function getRow(rowIndex: number): number[] {
    let output: number[][] = Array(rowIndex+1)
    .fill(null)
    .map((_, i) => Array(i + 1));
    for (let i = 1; i <= rowIndex + 1; i++) {
        for (let j = 1; j <= i; j++) {
            if (j == 1 || j == i) {
                //console.log(i, j);
                output[i-1][j-1] = 1;
            } else {
                //console.log(i, j, output[i-1][j], output[i-1][j+1], output);
                output[i-1][j-1] = output[i-2][j-1] + output[i-2][j-2];
            }
        }
    }
    return output[output.length - 1];
};