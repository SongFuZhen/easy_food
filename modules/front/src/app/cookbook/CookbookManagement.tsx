import * as React from "react";
import { RouteComponentProps } from "react-router";
import { observer } from "mobx-react";
import CookbookEdit from "./CookbookEdit";
import CookbookList from "./CookbookList";

type Props = RouteComponentProps<{ entityId?: string }>;

@observer
export class CookbookManagement extends React.Component<Props> {
  static PATH = "/cookbookManagement";
  static NEW_SUBPATH = "new";

  render() {
    const { entityId } = this.props.match.params;
    return (
      <>{entityId ? <CookbookEdit entityId={entityId} /> : <CookbookList />}</>
    );
  }
}
