import { createSlice } from "@reduxjs/toolkit";

const initialState = { 
  roleId: 0, 
  isValidLogin: false 
};

const loginSlice = createSlice({
  name: "loginSuccessful",
  initialState,
  reducers: {
    login: (state, action) => {
      state.isValidLogin = true;
      console.log("in loginSlice role id is...",action.payload);
      state.roleId = action.payload;
    },
    logout: (state) => {
      state.isValidLogin = false;
      state.roleId = 0;
    }
  }
});

// Export action creators
export const { login, logout } = loginSlice.actions;

// Export the reducer
export default loginSlice.reducer;

// Keep your existing action creators for compatibility (optional)
export function validateLogin(id) {
  return login(id); // or return login(id) if you want to use the actual id
}

export function validateLogout() {
  return logout();
}