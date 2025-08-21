// import { combineReducers, createStore } from "redux";

// import { loginReducer } from "../../features/loginSuccessful/loginSlice";
// const reducer = combineReducers({
//   accountLogin: loginReducer,
// });
// const store = createStore(reducer);

// export default store;

import { configureStore } from "@reduxjs/toolkit";
import loginReducer from "../../features/loginSuccessful/loginSlice";

const store = configureStore({
  reducer: {
    accountLogin: loginReducer,
  },
});

export default store;
