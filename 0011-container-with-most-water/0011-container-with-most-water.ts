function maxArea(height: number[]): number {
    let area: number = 0;
    let len: number = height.length
    let right: number = len - 1;
    let left: number = 0;
    while (left < right) {
        let calcArea = Math.min(height[left],height[right]) * Math.abs(left - right); 
        area = calcArea > area ? calcArea: area;
        if (height[left] < height[right]) {
            left += 1;
        } else {
            right -= 1;
        }
    }
    return area;
};